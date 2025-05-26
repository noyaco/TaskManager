import { useEffect, useState } from 'react';
import './App.css';
import TaskList from './TaskList/TaskList';

function App() {
  const [tasks, setTasks] = useState([]);
  const [newText, setNewText] = useState("");
  const [newDate, setNewDate] = useState("");

  const API_URL = process.env.REACT_APP_API_URL;



  

  useEffect(() => {
    fetch(`${API_URL}/tasks`)
      .then(response => {
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        return response.text();
      })
      .then(text => (text ? JSON.parse(text) : []))
      .then(data => {
        console.log("Fetched tasks:", data);
        setTasks(data);
      })
      .catch(error => console.error('Error fetching tasks:', error));
  }, [API_URL]);

  const handleDeleteTask = (id) => {
    fetch(`${API_URL}/tasks/${id}`, { method: 'DELETE' })
      .then(response => {
        if (!response.ok) throw new Error(`Failed to delete task with id ${id}`);
        setTasks(prevTasks => prevTasks.filter(task => task.id !== id));
      })
      .catch(error => console.error('Error deleting task:', error));
  };

  const handleToggleTask = (id) => {
    fetch(`${API_URL}/tasks/${id}`, { method: 'PATCH' })
      .then(response => {
        if (!response.ok) throw new Error(`Failed to toggle task with id ${id}`);
        return response.json();
      })
      .then(data => {
        setTasks(prevTasks =>
          prevTasks.map(task =>
            task.id === id ? { ...task, completed: !data.completed } : task
          )
        );
      })
      .catch(error => console.error('Error toggling task:', error));
  };

  const handleAddTask = () => {
    if (!newText || !newDate) return;
    const today = new Date();
  const selectedDate = new Date(newDate);

  
  today.setHours(0, 0, 0, 0);
  selectedDate.setHours(0, 0, 0, 0);

  if (selectedDate < today) {
    alert("תאריך לא בתוקף , אנא בחר תאריך מהיום או מתאריך עתידי");
    return;
  }

    const newTask = {
      title: newText,
      date: newDate,
      completed: false,
    };

    fetch(`${API_URL}/tasks`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newTask),
    })
      .then(response => {
        if (!response.ok) throw new Error('Failed to save task');
        return response.json();
      })
      .then(savedTask => {
        console.log('Saved task:', savedTask);
        if (savedTask && savedTask.id) {
          setTasks(prevTasks => [...prevTasks, savedTask]);
          setNewText('');
          setNewDate('');
        } else {
          console.error('Saved task is incomplete:', savedTask);
        }
      })
      .catch(error => console.error('Error adding task:', error));
  };

  return (
    <div className="app">
      <h1 className="app-header">מערכת לניהול משימות</h1>

      <div className="task-inputs">
        <input
          type="text"
          value={newText}
          onChange={e => setNewText(e.target.value)}
          placeholder="הזן משימה"
          id="new-task-input"
          className="task-input"
        />
        <input
          type="date"
          value={newDate}
          onChange={e => setNewDate(e.target.value)}
          id="new-task-date"
          className="date-input"
        />
        <button
          onClick={handleAddTask}
          id="add-task-button"
          className="add-button"
        >
          הוסף משימה
        </button>
      </div>

      <TaskList
        tasks={tasks}
        toggleTask={handleToggleTask}
        deleteTask={handleDeleteTask}
      />
    </div>
  );
}

export default App;
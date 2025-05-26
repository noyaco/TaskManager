import Task from '../Task/Task';



const TaskList = ({ tasks, deleteTask, toggleTask }) => {
  return (
    <ul className="task-list">
      {tasks.map((task) => (
        <Task
          key={task.id}
          id={task.id}
          title={task.title}
          date={task.date}
          completed={task.completed}
          deleteTask={deleteTask}
          toggleTask={toggleTask}
          className="task-item" 
        />
      ))}
    </ul>
  );
};

export default TaskList;
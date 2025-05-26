const Task = ({ id, title, date, completed, deleteTask, toggleTask, className }) => {
  const formattedDate = new Date(date).toLocaleDateString("he-IL", {
    day: "2-digit",
    month: "2-digit",
    year: "numeric",
  });

  return (
    <li className={className} id={`task-${id}`}>
      <div className="task-details">
        <input
          type="checkbox"
          checked={completed}
          onChange={() => toggleTask(id)}
          id={`task-checkbox-${id}`}
        />
        <span className={`task-text ${completed ? "completed" : ""}`}>
          {title} - {formattedDate}
        </span>
        <button
          onClick={() => deleteTask(id)}
          id={`delete-task-${id}`}
          className="delete-button"
        >
          מחיקה
        </button>
      </div>
    </li>
  );
};

export default Task;
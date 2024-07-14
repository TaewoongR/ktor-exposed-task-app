package com.example.model

class FakeTaskRepository: TaskRepository{
    private val tasks = mutableListOf(
        Task("cleaning", "Clean the house", Priority.Low),
        Task("gardening", "Mow the lawn", Priority.Medium),
        Task("shopping", "Buy the groceries", Priority.High),
        Task("painting", "Paint the fence", Priority.Medium)
    )

    override fun addTask(task: Task) {
        if(taskByName(task.name) != null){
            throw IllegalStateException ("cannot add duplicate task name")
        }
        tasks.add(task)
    }

    override fun removeTask(name: String): Boolean {
        return tasks.removeIf{it.name == name}
    }

    override fun allTasks(): List<Task> = tasks

    override fun tasksByPriority(priority: Priority): List<Task> {
        return tasks.filter{
            it.priority == priority
        }
    }

    override fun taskByName(name: String): Task? {
        return tasks.find{
            it.name.equals(name, ignoreCase = true)
        }
    }
}
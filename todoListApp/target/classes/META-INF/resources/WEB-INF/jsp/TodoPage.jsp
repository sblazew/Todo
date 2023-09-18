<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
		
	<div class="container">
	
		<h1>This is your to-do list ${name}</h1>

		<table class="table">
			<thead>
				<tr>
					<th>Task name</th>
					<th>Description</th>
					<th>Deadline</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.taskName}</td>
						<td>${todo.description}</td>
						<td>${todo.deadline}</td>
						<td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
						<td> <a href="edit-todo?id=${todo.id}" class="btn btn-success">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Task</a>
	</div>
<%@ include file="common/footer.jspf" %>
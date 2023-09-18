<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h1>Enter task details</h1>
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="taskName">Task name</form:label>
				<form:input type="text" path="taskName"/>
				<form:errors path="taskName" cssClass="text-warning"/>
			</fieldset>
			
			<fieldset class="mb-3">
				<form:label path="Description">Description</form:label>
				<form:input type="text" path="description"/>	
			</fieldset>
			
			<fieldset class="mb-3">
				<form:label path="deadline">Deadline</form:label>
				<form:input type="text" path="deadline"/>	
			</fieldset>
			
			<form:input type="hidden" path="id" />
			<input type="submit" class="btn btn-success"/>
			<a class="btn btn-warning" href="todolist">Cancel</a>
		</form:form>
	</div>

<%@ include file="common/footer.jspf" %>

	<script type="text/javascript">
		$('#deadline').datepicker({
   		 format: 'dd-mm-yyyy',   		
		});
	</script>
	

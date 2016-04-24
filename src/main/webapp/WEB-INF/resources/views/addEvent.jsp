<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(function() {
        $('#datetimepicker1').datetimepicker();
        $('#datetimepicker2').datetimepicker();
    });
</script>
<form method="post">
	<div class="form-group">
		<label for="name">Name</label> <input type="text" class="form-control"
			name="name" placeholder="Name">
	</div>
	<div class="form-group">
		<label for="price">Price</label> <input type="text"
			class="form-control" name="price" placeholder="Price">
	</div>
	<div class="form-group">
		<label for="rating">Rating</label>
		<div class="radio">
			<label><input type="radio" name="rating" value="HIGH">High</label>
		</div>
		<div class="radio">
			<label><input type="radio" name="rating" value="MID">Middle</label>
		</div>
		<div class="radio">
			<label><input type="radio" name="rating" value="LOW">Low</label>
		</div>
	</div>
	<div class="form-group">
		<div class='input-group date' id='datetimepicker1'>
			<input type='text' class="form-control" name="datetime" /> <span
				class="input-group-addon"> <span
				class="glyphicon glyphicon-calendar"></span>
			</span>
		</div>
	</div>
	<div class="form-group">
		<div class='input-group date' id='datetimepicker2'>
			<input type='text' class="form-control" name="datetime" /> <span
				class="input-group-addon"> <span
				class="glyphicon glyphicon-calendar"></span>
			</span>
		</div>
	</div>
	<button type="submit" class="btn btn-default">Save</button>
</form>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="items-list">
	<c:forEach items="${events}" var="event">
		<div>
			<h4 class="media-heading">${event.name}</h4>
			<div>
				<span>Price: ${event.basePrice}</span> <span>Rating:
					${event.rating}</span>
			</div>
		</div>
	</c:forEach>
</div>

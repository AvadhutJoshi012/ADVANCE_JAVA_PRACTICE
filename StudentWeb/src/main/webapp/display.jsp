<%@ page
	import="java.util.*, org.hibernate.*, org.hibernate.cfg.*, com.student.model.Student"%>

<h2>Student List</h2>

<table border="1" cellpadding="10">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
	</tr>

	<%
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session ss = factory.openSession();
	List<Student> list = ss.createQuery("from Student").list();

	for (Student s : list) {
	%>
	<tr>
		<td><%=s.getId()%></td>
		<td><%=s.getName()%></td>
		<td><%=s.getEmail()%></td>
	</tr>
	<%
	}
	%>

</table>

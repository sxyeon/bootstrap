<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">notices</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Name</th>
                                            <th>Date</th>
                                            <th>Title</th>
                                            <th>file</th>
                                        </tr>
                                    </thead>
                                 
                                    <tbody>
                                    	<c:forEach items ="${notices }" var="notice">
                                    		<tr>
                                    			<td>${notice.nNo }</td>
                                    			<td>${notice.nName }</td>
                                    			<td>${notice.nDate }</td>
                                    			<td>${notice.nTitle }</td>
                                    			<td>
                                    				<c:if test="${not empty notice.nFileName}">
                                    					첨부파일 있음
                                    				</c:if>
                                    				<c:if test="${empty notice.nFileName}">
                                    					첨부파일 없음
                                    				</c:if>
                                    			</td>
                                    		</tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
                
                
</body>
</html>
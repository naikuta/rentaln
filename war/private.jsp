<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%
     BlobstoreService blobstoreService
          = BlobstoreServiceFactory.getBlobstoreService();
     String uploadUrl
          = blobstoreService.createUploadUrl("/upload");
%>
<html>
<body>
<form
     action="<%= uploadUrl %>"
     method="POST"
     enctype="multipart/form-data">
<input type="file" name="file1">
<input type="submit" value="Upload">
</form>
</body>
</html>
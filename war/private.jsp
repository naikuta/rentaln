<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%
     BlobstoreService blobstoreService
          = BlobstoreServiceFactory.getBlobstoreService();
     String uploadUrl
          = blobstoreService.createUploadUrl("/upload");
%>
<html>
    <head>
        <meta http-equiv="Content-Type"
            content="text/html; charset=utf-8">
        <title>個人ページ</title>
    </head>
    <body>
        <h1>Private Page</h1>
        <div>※このページは、公開されていないプライベートなページです。</div>
        <div style="font-weight: bold;">ユーザー：</div>
        <br>
        master
        <a href="/logout">Logout</a>
    </body>
</html>
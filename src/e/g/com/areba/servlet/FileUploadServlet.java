package e.g.com.areba.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@SuppressWarnings("serial")
public class FileUploadServlet extends HttpServlet {

     private BlobstoreService blobstoreService
          = BlobstoreServiceFactory.getBlobstoreService();

     public void doPost(
          HttpServletRequest request,
          HttpServletResponse response )
          throws ServletException, IOException {

          Map<String, BlobKey> blobs
               = blobstoreService.getUploadedBlobs(request);
          BlobKey blobKey = blobs.get("file1");

          response.sendRedirect(
               "/blobinfo.jsp?blobkey=" + blobKey.getKeyString());

     }
}
package ch.squix.extraleague.servlets;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.squix.extraleague.rest.games.OpenGamesResource;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class UploadServlet extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	private static final Logger log = Logger.getLogger(UploadServlet.class.getName());

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        //Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
        log.info("Size of map: " + blobs.size());
//        for (Map.Entry<String, List<BlobKey>> entry : blobs.entrySet()) {
//        	log.info(entry.getKey() + ":");
//        	for (BlobKey key : entry.getValue()) {
//        		log.info("--" + key.getKeyString());
//        	}
//        }
        if (blobs.size() == 0) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
        	BlobKey blobKey = blobs.get("file");
            res.getWriter().print("/serve?blob-key=" + blobKey.getKeyString());
        }
    }
}
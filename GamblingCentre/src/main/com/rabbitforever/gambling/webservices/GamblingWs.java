package com.rabbitforever.gambling.webservices;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rabbitforever.gambling.models.eos.AboutEo;
import com.rabbitforever.gambling.models.sos.AboutSo;
import com.rabbitforever.gambling.services.AboutMgr;
import com.rabbitforever.gambling.services.ServiceBase;

// http://localhost:8080/GamblingCentre/rest/gamblingWs/test
// http://localhost:8080/GamblingCentre/rest/gamblingWs/upload
// http://localhost:8080/GamblingCentre/rest/gamblingWs/requestAboutInfo
@Path("/gamblingWs")
public class GamblingWs {
	private final Logger logger = LoggerFactory.getLogger(getClassName());

	private String getClassName() {
		return this.getClass().getName();
	}

	@GET
	@Path("/test")
	@Produces("text/plain")
	public String test() {
		String returnString = "";
		try {
			returnString = "Test return from Gambling Test()";
		} catch (Exception e) {
			logger.error(getClassName() + ".test() - Exception: ", e);
		}
		return returnString;
	}

	@GET
	@Path("/requestAboutInfo")
	@Produces("text/plain")
	public Response requestAboutInfo() {
		String returnString = "";
		Response response = null;
		AboutMgr mgr = null;
		List<AboutEo> aboutEoList=null;
		try {
			mgr = new AboutMgr(ServiceBase.CONNECTION_TYPE_HIBERNATE);
			AboutSo so = new AboutSo();
			aboutEoList = mgr.read(so);
			Gson gson = new GsonBuilder().create();
			returnString = gson.toJson(aboutEoList);

			ResponseBuilder builder = Response.status(201).entity(returnString);
			response = builder.build();

		} catch (Exception e) {
			logger.error(getClassName() + ".requestAboutInfo() - Exception: ", e);
		}
		return response;
	}

	@POST
	@Path("/upload")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response uploadPdfFile(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception {
		String UPLOAD_PATH = "c:/temp/";
		try {
			int read = 0;
			byte[] bytes = new byte[1024];

			OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileMetaData.getFileName()));
			while ((read = fileInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			throw new WebApplicationException("Error while uploading file. Please try again !!");
		}
		return Response.ok("Data uploaded successfully !!").build();
	}
}

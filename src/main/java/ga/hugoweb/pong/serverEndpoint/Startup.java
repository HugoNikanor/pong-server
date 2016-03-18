package ga.hugoweb.pong.serverEndpoint;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class Startup implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//System.out.println("initialized");
		System.out.println( servletContext.toString() );
	}
}


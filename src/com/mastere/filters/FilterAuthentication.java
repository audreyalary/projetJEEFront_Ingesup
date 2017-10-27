package com.mastere.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterAuthentication
 */
@WebFilter(urlPatterns = { "/devis/*" }, 
	servletNames = { "ServletDeTest" })
public class FilterAuthentication implements Filter {

    /**
     * Default constructor. 
     */
    public FilterAuthentication() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		if(req.getSession().getAttribute("USER") == null){
			HttpServletResponse resp = (HttpServletResponse)response;
			String url = req.getContextPath() + "/auth/login";
			try {
				req.getSession().setAttribute("REDIRECT", req.getRequestURI());
				resp.sendRedirect(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

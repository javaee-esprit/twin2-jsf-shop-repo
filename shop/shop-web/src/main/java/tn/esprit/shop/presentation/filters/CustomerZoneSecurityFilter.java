package tn.esprit.shop.presentation.filters;

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

import tn.esprit.shop.presentation.mbeans.IndentityBean;

@WebFilter("/pages/customer/*")
public class CustomerZoneSecurityFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Customer Filter has just been created");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		IndentityBean identity = (IndentityBean) req.getSession().getAttribute("identity");
		Boolean letGo = false;
		if(
				(identity != null)&&
				(identity.getIdentifiedUser()!=null)&&
				(identity.hasRole("Customer"))
				){
			
			letGo = true;
		}
		if (letGo) {
			chain.doFilter(request, response);
		}else{
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath()+ "/pages/login.jsf");
		}
		
	}

	public void destroy() {
		System.out.println("Customer Filter will shortly be destroyed");
	}

}

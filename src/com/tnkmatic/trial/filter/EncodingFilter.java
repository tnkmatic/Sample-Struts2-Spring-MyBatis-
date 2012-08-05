/**
 *
 */
package com.tnkmatic.trial.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author eiichi
 *
 */
public class EncodingFilter implements Filter {
	private String endcoding = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		endcoding = config.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(endcoding);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		return;
	}
}

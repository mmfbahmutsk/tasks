package com.epam.stuffshop.command.catalog;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;

import com.epam.stuffshop.command.IActionCommand;
import com.epam.stuffshop.exception.ControllerException;
import com.epam.stuffshop.resource.ConfigurationManager;
import com.epam.stuffshop.resource.ParametersEnum;

public abstract class CatalogSurfCommand implements IActionCommand {

	private static final String CATALOG = "catalog";
	private static final String page = ConfigurationManager
			.getProperty("path.page.catalog");

	void createPageContent(StringWriter stringWriter, HttpServletRequest request) {
		request.setAttribute(CATALOG, stringWriter.getBuffer());
	}

	void forvardRequest(HttpServletRequest request, HttpServletResponse response)
			throws ControllerException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new ControllerException("Forward is failed. ", e);
		}
	}

	void setTransformerParameters(HttpServletRequest request,
			Transformer transformer) {

		String category = request.getParameter(ParametersEnum.CATEGORY_NAME_JSP
				.getParameterName());
		if (category != null) {
			transformer.setParameter(
					ParametersEnum.CATEGORY_NAME_TRANSFORMARION
							.getParameterName(), category);
		}

		String subcategory = request
				.getParameter(ParametersEnum.SUBCATEGORY_NAME_JSP
						.getParameterName());
		if (subcategory != null) {
			transformer.setParameter(
					ParametersEnum.SUBCATEGORY_NAME_TRANSFORMARION
							.getParameterName(), subcategory);
		}
	}

}

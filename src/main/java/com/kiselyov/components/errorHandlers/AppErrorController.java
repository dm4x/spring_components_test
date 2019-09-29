package com.kiselyov.components.errorHandlers;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class AppErrorController implements ErrorController {

    private ErrorAttributes errorAttributes;

    private final static String ERROR_PATH = "/error";

    public AppErrorController(ErrorAttributes errorAttributes){
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        return new ModelAndView("/errors/error", getErrorAttributes(request, false));
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    private boolean getTraceParameter(HttpServletRequest request){
        String parameter = request.getParameter("trace");
        if (parameter == null){
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace){
        WebRequest requestAttributes = new ServletWebRequest(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    private HttpStatus getStatus(HttpServletRequest request){
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if(statusCode != null) {
            try{
                return HttpStatus.valueOf(statusCode);
            }catch (Exception ex){
            }
        }
        return HttpStatus.NOT_FOUND;
    }
}

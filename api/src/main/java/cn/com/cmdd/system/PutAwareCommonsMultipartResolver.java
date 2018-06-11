/**
 * 
 */
package cn.com.cmdd.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/** 
 * @ClassName: PutAwareCommonsMultipartResolver 
 * @Description: TODO 
 * @author wangcan 
 * @date 2015年12月20日 下午1:49:17 
 *  
 */
public class PutAwareCommonsMultipartResolver extends CommonsMultipartResolver {

    private static final String MULTIPART = "multipart/";

    @Override
    public boolean isMultipart(HttpServletRequest request) {
        return request != null && isMultipartContent(request);
    }

    /**
     * Utility method that determines whether the request contains multipart
     * content.
     * 
     * @param request The servlet request to be evaluated. Must be non-null.
     * 
     * @return <code>true</code> if the request is multipart; {@code false}
     * otherwise.
     * 
     * @see ServletFileUpload#isMultipartContent(HttpServletRequest)
     */
    public static final boolean isMultipartContent(HttpServletRequest request) {
        final String method = request.getMethod().toLowerCase();
        if (!method.equals("post") && !method.equals("put")) {
            return false;
        }
        String contentType = request.getContentType();
        if (contentType == null) {
            return false;
        }
        if (contentType.toLowerCase().startsWith(MULTIPART)) {
            return true;
        }
        return false;
    }
}
package jp.co.tottori.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jp.co.tottori.dto.ManageDto;

public class UserInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        // ここに共通の処理を書きます。

    	ManageDto loginUser = ManageDto.getManageDto();
    	if(loginUser == null|| loginUser.getLibraryId() == 0) {
    		response.sendRedirect("http://localhost:8080/Tottori/");
    		return false;
    	}

        // 戻り値は必ずtrueに変更して下さい。falseだとコントローラクラスが動きません。
        return true;
    }

    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // 空実装
    }

    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
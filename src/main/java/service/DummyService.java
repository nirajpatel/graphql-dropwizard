package service;

import api.DummyApi;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shanshan Jiang on 4/7/2016.
 */
public class DummyService implements DummyApi {
    public String getSomething(HttpServletRequest request) {
        System.out.println(request);
        return "All right";
    }
}

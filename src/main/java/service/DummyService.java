package service;

import api.DummyApi;
import sandbox.HumanQuery;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shanshan Jiang on 4/7/2016.
 */
public class DummyService implements DummyApi {
    public Map<String, Object> getSomething(HttpServletRequest request) {
        String requestPayload = ServiceUtil.getRequestPayload(request);
        return HumanQuery.humanQueryTest(requestPayload);
    }


}

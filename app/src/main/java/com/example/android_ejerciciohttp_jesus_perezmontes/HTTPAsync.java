package com.example.android_ejerciciohttp_jesus_perezmontes;

import android.content.Context;
import android.os.AsyncTask;

public class HTTPAsync extends AsyncTask<Object, Void, Object> {
    public AsyncResponse delegate = null;
    public HTTPAsync() { }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object... params) {
        Context context = (Context) params[0];
        String requestType = (String) params[1];
        Object requestParam = params[2];

        if("get".equals(requestType)){
            return HTTPResponse.getHttpResponse(Utils.URL);
        }else if("getparam".equals(requestType)){
            return HTTPResponse.getParamHttpResponse(Utils.URL + requestParam);
        }else if("post".equals(requestType)){
            return HTTPResponse.postHttpResponse(Utils.URL, (String[]) requestParam);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        if(result != null){
            delegate.processFinish(result);
        }
    }
}

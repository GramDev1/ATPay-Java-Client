package io.atpay.client.data;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Order
{

    private final String id;
    private final long value;
    private final String currency;
    private final String callbackUrl;
    private final String successURLReturn;
    private final String failURLReturn;

    Order(String id, long value, String currency, String callbackUrl, String successURLReturn, String failURLReturn)
    {
        this.id = id;
        this.value = value;
        this.currency = currency;
        this.callbackUrl = callbackUrl;
        this.successURLReturn = successURLReturn;
        this.failURLReturn = failURLReturn;
    }

    public String getId()
    {
        return id;
    }

    public long getValue()
    {
        return value;
    }

    public String getCurrency()
    {
        return currency;
    }

    public String getCallbackUrl()
    {
        return callbackUrl;
    }

    public String getSuccessURLReturn()
    {
        return successURLReturn;
    }

    public String getFailURLReturn()
    {
        return failURLReturn;
    }

    public static OrderBuilder builder()
    {
        return new OrderBuilder();
    }

    public String toJSON()
    {
        Map<String,Object> jsonMap = new HashMap<>();
        jsonMap.put("customInvoiceId",id);
        jsonMap.put("value",value);
        jsonMap.put("currency",currency);
        jsonMap.put("ipnUrl",callbackUrl);
        Map<String,String> redirects = new HashMap<>();
        redirects.put("success",successURLReturn);
        redirects.put("return",failURLReturn);
        jsonMap.put("redirectUrls",redirects);

        Gson gson = new Gson();
        return gson.toJson(jsonMap);

    }
}

package io.atpay.client;

import io.atpay.client.data.Order;
import io.atpay.client.exception.OrderCreationException;
import okhttp3.*;

import java.io.IOException;

public class ATPay
{

    private static MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String apiKey;
    private OkHttpClient client;

    public ATPay(String apiKey)
    {
        this.apiKey = apiKey;
        this.client = new OkHttpClient();
    }

    public ATPay(String apiKey, OkHttpClient client)
    {
        this.apiKey = apiKey;
        this.client = client;
    }

    /**
     * Creates a new ATPay {@link Order} using the given {@link Order}
     *
     * @param order The order instance to submit to ATPay
     *
     * @return A checkout link for the user
     * @throws OrderCreationException If the server returned an error.
     * @throws IOException            If the request to ATPay API failed
     * @see <a href=https://docs.atpay.io/rest/order-create.html></a> for more info.
     */
    public String newOrder(Order order) throws OrderCreationException, IOException
    {
        Request request = new Request.Builder().url("https://atpay.io/api/order/create").header("X-Authorization", apiKey).header("User-Agent", "ATPay Java Client").post(RequestBody.create(JSON, order.toJSON())).build();
        Response response = client.newCall(request).execute();
        String responseString = response.toString();
        if (response.code() != 200)
        {
            throw new OrderCreationException(responseString);
        }
        return responseString;
    }
}

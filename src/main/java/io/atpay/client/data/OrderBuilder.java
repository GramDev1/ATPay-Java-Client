package io.atpay.client.data;
import static java.util.Objects.requireNonNull;
public class OrderBuilder
{

    private String id;
    private Long value;
    private String currency;
    private String callbackUrl;
    private String successURLReturn;
    private String failURLReturn;

    public OrderBuilder id(String id)
    {
        this.id = id;
        return this;
    }

    public OrderBuilder value(long value)
    {
        this.value = value;
        return this;
    }

    public OrderBuilder currency(String currency)
    {
        this.currency = currency;
        return this;
    }

    public OrderBuilder callbackURL(String callbackUrl)
    {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public OrderBuilder successReturnURL(String successURLReturn)
    {
        this.successURLReturn = successURLReturn;
        return this;
    }

    public OrderBuilder failureReturnURL(String failURLReturn)
    {
        this.failURLReturn = failURLReturn;
        return this;
    }

    public Order build() throws NullPointerException
    {
        requireNonNull(id,"An Order ID must be set!");
        requireNonNull(value,"A Product Value must be set!");
        requireNonNull(currency,"A Product currency must be set!");
        requireNonNull(callbackUrl,"An IPN callback URL must be set!");
        requireNonNull(successURLReturn,"A payment success URL must be set!");
        requireNonNull(failURLReturn,"A payment failure URL must be set!");
        return new Order(id,value,currency,callbackUrl,successURLReturn,failURLReturn);

    }
    protected OrderBuilder() {}



}

package io.atpay.client.exception;

public class OrderCreationException extends Exception
{

    public OrderCreationException(String error)
    {
        super(error);
    }
}

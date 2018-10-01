# ATPay Java Client
### _A simple java client for the [ATPay](https://atpay.io) service_

## Dependency Management
We use [Jitpack](https://jitpack.io) for our build server. 
You can access more instructions [here](https://jitpack.io/#mcjp78/ATPay-Java-Client/1.0)
### Maven
Add the repository
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
	<url>https://jitpack.io</url>
    </repository>
</repositories>
```
Add the dependency
```xml
<dependency>
    <groupId>com.github.mcjp78</groupId>
    <artifactId>ATPay-Java-Client</artifactId>
    <version>1.0</version>
</dependency>	
```
### Gradle
Add the jitpack repository service.
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency

`implementation 'com.github.mcjp78:ATPay-Java-Client:1.0'`
## Examples

### Creating a new order
```java
ATPay instance = new ATPay("123456"); //Build an ATPay Client with the default OkHttpClient (this can be changed if you need a proxy, etc)
try
{
    Order order = Order.builder() //Create a new Object Builder
                        .id("1223") //Set a Unique ID for the order for your records
                        .currency("USD") //Set the currency for the order. Currently only "USD" is supported
                        .failureReturnURL("https://atpay.io/failure") //Set the URL to return to on order cancel/order failure
                        .successReturnURL("https://atpay.io/success") //Set the URL to return to on order success
                        .value(1000) //Set the value of the order in CENTS. So 1$ USD = 100 Cents.
                        .build(); // Build the Order
    String checkoutURL = instance.newOrder(order); //Submit the order to the ATPay API
}
catch (OrderCreationException e)
{
    //Handle Creation Error
}
catch (IOException ex)
{
    //Handle IO Error
}
```

For more info on order creation, visit [The Order Documentation on ATPay Docs](https://docs.atpay.io/rest/order-create.html#example-request)

# Java Serverless AWS Example

A Java + AWS serverless example app that shows how to create a Java REST endpoint on AWS and secure it with Okta and JWT. 

Please read [Serverless Java with Amazon Web Services](https://developer.okta.com/blog/2020/05/27/serverless-java-aws) to see how this example was created.

**Prerequisites**:

- [Java 11](https://sdkman.io/)
- [HTTPie](https://httpie.org/docs#installation)
- An [Okta Developer Account](https://developer.okta.com/signup/)
- An [Amazon Web Services](https://aws.amazon.com/) account with billing activated

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage, and secure users + roles in any application.

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

To install this example application, run the following commands:

```bash
git clone https://github.com/oktadeveloper/okta-java-serverless-aws-example.git
cd okta-java-serverless-aws-example
```

This will get a copy of the project installed locally. 

### Create an OIDC App in Okta

You will need to create an OIDC application.

1. From the top menu, click on the **Application** button. Click the **Add Application** button.
2. Select application type **Web**.
3. Click **Next**.
4. Give the app a name. I named mine `Okta Serverless Lambda`.
5. Under **Login redirect URIs**, add a new URI: `https://oidcdebugger.com/debug`

The rest of the default values will work.

Click **Done**.

Leave the page open or take note of the Client ID. You'll need it in a bit when you generate a token.

Open `src/main/resources/config.properties` and fill in the correct value for `okta.oauth.issuer` using your Okta developer URI. It will look something like `dev-123456.okta.com`. You can find it by going to your Okta developer dashboard and, from the top menu, selecting **API** and **Authorization servers**. You want the **Issuer URI** for the **default** authorization server in the table.

```properties
okta.oauth.issuer=https://{yourOktaUrl}/oauth2/default
okta.oauth.audience=api://default
okta.oauth.connectionTimeoutSeconds=10
okta.oauth.readTimeoutSeconds=10
```

**NOTE:** The value of `{yourOktaUrl}` should be something like `dev-123456.okta.com`. Make sure you don't include `-admin` in the value!

After modifying this file your app will be protected by Okta! See this repo's [blog post](https://developer.okta.com/blog/2020/05/27/serverless-java-aws) to learn how to deploy this example on AWS Lambda.

## Links

This example uses [Okta JWT Verifier for Java](https://github.com/okta/okta-jwt-verifier-java) to integrate with Okta.

## Help

Please post any questions as comments on the [blog post](https://developer.okta.com/blog/2020/05/27/serverless-java-aws), or visit our [Okta Developer Forums](https://devforum.okta.com/). 

## License

Apache 2.0, see [LICENSE](LICENSE).

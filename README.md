# SaladCloudImdsSdk Java SDK 0.9.0-alpha.4

Welcome to the SaladCloudImdsSdk SDK documentation. This guide will help you get started with integrating and using the SaladCloudImdsSdk SDK in your project.

## Versions

- API version: `0.9.0-alpha.1`
- SDK version: `0.9.0-alpha.4`

## About the API

The SaladCloud Instance Metadata Service (IMDS). Please refer to the [SaladCloud API Documentation](https://docs.salad.com/api-reference) for more details.

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)
- [License](#license)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>com.salad.cloud</groupId>
    <artifactId>imds-sdk</artifactId>
    <version>0.9.0-alpha.4</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation group: com.salad.cloud, name: imds-sdk, version: 0.9.0-alpha.4
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.config.SaladCloudImdsSdkConfig;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdkConfig config = SaladCloudImdsSdkConfig.builder().timeout(10000).build();
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk(config);
  }
}

```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.ContainerStatus;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    ContainerStatus response = saladCloudImdsSdk.metadataService.getContainerStatus();

    System.out.println(response);
  }
}

```

## Services

The SDK provides various services to interact with the API.

<details> 
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                         |
| :----------------------------------------------------------- |
| [MetadataService](documentation/services/MetadataService.md) |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details> 
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                               | Description                                              |
| :----------------------------------------------------------------- | :------------------------------------------------------- |
| [ReallocateContainer](documentation/models/ReallocateContainer.md) | Represents a request to reallocate a container.          |
| [ContainerStatus](documentation/models/ContainerStatus.md)         | Represents the health statuses of the running container. |
| [ContainerToken](documentation/models/ContainerToken.md)           | Represents the identity token of the running container.  |

</details>

## License

This SDK is licensed under the MIT License.

See the [LICENSE](LICENSE) file for more details.

# MetadataService

A list of all methods in the `MetadataService` service. Click on the method name to view detailed information about that method.

| Methods                                     | Description                                             |
| :------------------------------------------ | :------------------------------------------------------ |
| [reallocateContainer](#reallocatecontainer) | Reallocates the running container to another Salad Node |
| [getContainerStatus](#getcontainerstatus)   | Gets the health statuses of the running container       |
| [getContainerToken](#getcontainertoken)     | Gets the identity token of the running container        |

## reallocateContainer

Reallocates the running container to another Salad Node

- HTTP Method: `POST`
- Endpoint: `/v1/reallocate`

**Parameters**

| Name                | Type                                                      | Required | Description  |
| :------------------ | :-------------------------------------------------------- | :------- | :----------- |
| reallocateContainer | `[ReallocateContainer](../models/ReallocateContainer.md)` | ✅       | Request Body |

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.ReallocateContainer;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    ReallocateContainer reallocateContainer = ReallocateContainer.builder().reason("laborum culpa").build();

    saladCloudImdsSdk.metadataService.reallocateContainer(reallocateContainer);
  }
}

```

## getContainerStatus

Gets the health statuses of the running container

- HTTP Method: `GET`
- Endpoint: `/v1/status`

**Return Type**

`ContainerStatus`

**Example Usage Code Snippet**

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

## getContainerToken

Gets the identity token of the running container

- HTTP Method: `GET`
- Endpoint: `/v1/token`

**Return Type**

`ContainerToken`

**Example Usage Code Snippet**

```java
import com.salad.cloud.imdssdk.SaladCloudImdsSdk;
import com.salad.cloud.imdssdk.models.ContainerToken;

public class Main {

  public static void main(String[] args) {
    SaladCloudImdsSdk saladCloudImdsSdk = new SaladCloudImdsSdk();

    ContainerToken response = saladCloudImdsSdk.metadataService.getContainerToken();

    System.out.println(response);
  }
}

```

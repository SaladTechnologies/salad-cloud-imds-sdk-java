package com.salad.cloud.imdssdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.salad.cloud.imdssdk.exceptions.ApiException;
import com.salad.cloud.imdssdk.http.HttpMethod;
import com.salad.cloud.imdssdk.http.ModelConverter;
import com.salad.cloud.imdssdk.http.util.RequestBuilder;
import com.salad.cloud.imdssdk.models.ContainerStatus;
import com.salad.cloud.imdssdk.models.ContainerToken;
import com.salad.cloud.imdssdk.models.ReallocateContainer;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.exceptions.ValidationException;
import com.salad.cloud.imdssdk.validation.validators.modelValidators.ReallocateContainerValidator;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * MetadataService Service
 */
public class MetadataService extends BaseService {

  public MetadataService(@NonNull OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * Reallocate Container
   *
   * @param reallocateContainer {@link ReallocateContainer} Request Body
   * @return response of {@code Void}
   */
  public void reallocateContainer(@NonNull ReallocateContainer reallocateContainer)
    throws ApiException, ValidationException {
    Request request = this.buildReallocateContainerRequest(reallocateContainer);
    this.execute(request);
  }

  /**
   * Reallocate Container
   *
   * @param reallocateContainer {@link ReallocateContainer} Request Body
   * @return response of {@code Void}
   */
  public CompletableFuture<Void> reallocateContainerAsync(@NonNull ReallocateContainer reallocateContainer)
    throws ApiException, ValidationException {
    Request request = this.buildReallocateContainerRequest(reallocateContainer);
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> null);
  }

  private Request buildReallocateContainerRequest(@NonNull ReallocateContainer reallocateContainer)
    throws ValidationException {
    new ViolationAggregator()
      .add(new ReallocateContainerValidator("reallocateContainer").validate(reallocateContainer))
      .validateAll();

    return new RequestBuilder(HttpMethod.POST, this.serverUrl, "v1/reallocate")
      .setJsonContent(reallocateContainer)
      .build();
  }

  /**
   * Get Container Status
   *
   * @return response of {@code ContainerStatus}
   */
  public ContainerStatus getContainerStatus() throws ApiException {
    Request request = this.buildGetContainerStatusRequest();
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ContainerStatus>() {});
  }

  /**
   * Get Container Status
   *
   * @return response of {@code ContainerStatus}
   */
  public CompletableFuture<ContainerStatus> getContainerStatusAsync() throws ApiException {
    Request request = this.buildGetContainerStatusRequest();
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<ContainerStatus>() {});
    });
  }

  private Request buildGetContainerStatusRequest() {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "v1/status").build();
  }

  /**
   * Get Container Token
   *
   * @return response of {@code ContainerToken}
   */
  public ContainerToken getContainerToken() throws ApiException {
    Request request = this.buildGetContainerTokenRequest();
    Response response = this.execute(request);

    return ModelConverter.convert(response, new TypeReference<ContainerToken>() {});
  }

  /**
   * Get Container Token
   *
   * @return response of {@code ContainerToken}
   */
  public CompletableFuture<ContainerToken> getContainerTokenAsync() throws ApiException {
    Request request = this.buildGetContainerTokenRequest();
    CompletableFuture<Response> response = this.executeAsync(request);

    return response.thenApplyAsync(res -> {
      return ModelConverter.convert(res, new TypeReference<ContainerToken>() {});
    });
  }

  private Request buildGetContainerTokenRequest() {
    return new RequestBuilder(HttpMethod.GET, this.serverUrl, "v1/token").build();
  }
}

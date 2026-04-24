package com.salad.cloud.imdssdk.exceptions;

import com.salad.cloud.imdssdk.models.SaladCloudImdsError;
import lombok.Getter;
import okhttp3.Response;

/**
 * Exception class for API errors with structured SaladCloudImdsError error details.
 * Extends ApiError to provide typed access to the error response model.
 * Thrown when the API returns an error response that can be deserialized to SaladCloudImdsError.
 */
@Getter
public class SaladCloudImdsErrorException extends ApiError {

  /** The structured error details from the API response */
  private final SaladCloudImdsError error;

  /**
   * Creates a new exception with structured error details.
   *
   * @param error The deserialized error model
   * @param message The error message
   * @param code The HTTP status code
   * @param response The raw HTTP response
   */
  public SaladCloudImdsErrorException(SaladCloudImdsError error, String message, int code, Response response) {
    super(message, code, response);
    this.error = error;
  }
}

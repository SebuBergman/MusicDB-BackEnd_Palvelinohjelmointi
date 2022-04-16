package hhpalvelinohjelmointi.Musicdb;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)   
@DataJpaTest
class RestEndpointsJsonTest {
	
	@Test
	public void checkIfRestEndpointSongs_ResponseContentTypeisJson() throws ClientProtocolException, IOException {
	 
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/songs" );

	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );

	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( jsonMimeType, mimeType );
	}
	
	@Test
	public void checkIfRestEndpointSongsById_ResponseContentTypeisJson() throws ClientProtocolException, IOException {
	 
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/songs/12" );

	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );

	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( jsonMimeType, mimeType );
	}
	
	@Test
	public void checkIfRestEndpointSongsByIdAlbums_ResponseContentTypeisJson() throws ClientProtocolException, IOException {
	 
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/songs/12/albums" );

	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );

	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( jsonMimeType, mimeType );
	}
	
	@Test
	public void checkIfRestEndpointAlbums_ResponseContentTypeisJson() throws ClientProtocolException, IOException {
	 
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/albums" );

	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );

	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( jsonMimeType, mimeType );
	}
	
	@Test
	public void checkIfRestEndpointAlbumsById_ResponseContentTypeisJson() throws ClientProtocolException, IOException {
	 
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/albums/1" );

	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );

	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( jsonMimeType, mimeType );
	}
	
	@Test
	public void checkIfRestEndpointAlbumsByIdSongs_ResponseContentTypeisJson() throws ClientProtocolException, IOException {
	 
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/albums/1/songs" );

	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );

	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( jsonMimeType, mimeType );
	}
}

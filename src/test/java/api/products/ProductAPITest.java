package api.products;

import api.BaseTest;
import utils.FileReaderUtil;
import org.testng.annotations.Test;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductAPITest extends BaseTest {

	@Test
	public void testGetAllProducts() {
		given().spec(requestSpec).when().get("/products").then().statusCode(200).body("size()", greaterThan(0))
				.body("[0].id", notNullValue());
	}

	@Test
	public void testCreateProduct() throws IOException {
		String productJson = FileReaderUtil.readFile("test-data/products/create-product.json");

		given().spec(requestSpec).body(productJson).when().post("/products").then().statusCode(200)
				.body("id", notNullValue()).body("title", equalTo("Test Product"));
	}

	@Test
	public void testUpdateProduct() throws IOException {
		String updatedProduct = FileReaderUtil.readFile("test-data/products/update-product.json");

		given().spec(requestSpec).body(updatedProduct).when().put("/products/1").then().statusCode(200)
				.body("title", equalTo("Updated Product")).body("price", equalTo(19.99f));
	}

	@Test
	public void testDeleteProduct() {
		given().spec(requestSpec).when().delete("/products/1").then().statusCode(200);
	}
}
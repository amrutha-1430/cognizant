import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// 1. Define the dependency interface
interface ExternalApi {
    String getData();
}

// 2. Define the service being tested
class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}

// 3. The test execution
public class MyServiceTest {
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
        when(mockApi.getData()).thenReturn("Mock Data"); 
        
        MyService service = new MyService(mockApi); 
        String result = service.fetchData(); 
        
        assertEquals("Mock Data", result); 
    } 
}

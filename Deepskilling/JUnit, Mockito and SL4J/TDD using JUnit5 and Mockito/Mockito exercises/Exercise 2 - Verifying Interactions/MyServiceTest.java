import static org.mockito.Mockito.*;
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

    public void fetchData() {
        externalApi.getData();
    }
}

// 3. The test execution
public class MyServiceTest {
    @Test
    public void testVerifyInteraction() { 
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
        MyService service = new MyService(mockApi); 
        
        service.fetchData(); 
        
        verify(mockApi).getData(); 
    } 
}

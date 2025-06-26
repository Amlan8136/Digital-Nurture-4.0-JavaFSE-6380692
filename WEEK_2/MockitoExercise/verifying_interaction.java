import static org.mockito.Mockito.*;
import org.junit.Test;

interface ApiInterface {
    String getData();
}

class DataService {
    private ApiInterface api;

    public DataService(ApiInterface api) {
        this.api = api;
    }

    public void fetchData() {
        api.getData(); 
    }
}

public class verifying_interaction {
    @Test
    public void testVerifyInteraction() {
        ApiInterface mockApi = mock(ApiInterface.class);
        DataService service = new DataService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }
}

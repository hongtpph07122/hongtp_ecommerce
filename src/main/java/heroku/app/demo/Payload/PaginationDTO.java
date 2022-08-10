package heroku.app.demo.Payload;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaginationDTO {

    public static Map<String, Object> buildPaginationDTO (Page<?> page, List listDTO){
        Map<String, Object> response = new HashMap<>();
        response.put("dataList", listDTO);
        response.put("currentPage", page.getNumber());
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());
        return response;
    }
}

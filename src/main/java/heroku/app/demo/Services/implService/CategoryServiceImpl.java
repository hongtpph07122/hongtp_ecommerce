package heroku.app.demo.Services.implService;

import heroku.app.demo.DTOs.CategoryDTO;
import heroku.app.demo.Entities.Category;
import heroku.app.demo.Exceptions.ErrorMessage;
import heroku.app.demo.HResponse.HResponse;
import heroku.app.demo.Payload.PaginationDTO;
import heroku.app.demo.Repositories.CategoryRepository;
import heroku.app.demo.Services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ModelMapper mapper;
    @Override
    public HResponse getAllCategory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> pageCategory;
        pageCategory = categoryRepository.findAll(pageable);
        List<CategoryDTO> categoryDTOList = pageCategory.getContent()
                .stream()
                .map( category -> mapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
        return HResponse.buildHResponse(PaginationDTO.buildPaginationDTO(pageCategory, categoryDTOList));
    }

    @Override
    public HResponse createOrUpdateCategory(CategoryDTO dto) {

        if(dto.getParentId() != null){
            Category category = categoryRepository.findByParentId(dto.getParentId());
            if(category == null){
                return HResponse.buildHResponse(ErrorMessage.CATEGORY_NOT_EXIST);
            }
        }else{
            dto.setParentId((long) 0);
        }

        Category category1 = categoryRepository.save(mapper.map(dto, Category.class));

        return HResponse.buildHResponse(category1);
    }
}

package heroku.app.demo.Services.implService;

import heroku.app.demo.DTOs.CategoryDTO;
import heroku.app.demo.DTOs.TagDTO;
import heroku.app.demo.Entities.Category;
import heroku.app.demo.Entities.Tag;
import heroku.app.demo.Exceptions.ErrorMessage;
import heroku.app.demo.HResponse.HResponse;
import heroku.app.demo.Payload.PaginationDTO;
import heroku.app.demo.Repositories.TagRepository;
import heroku.app.demo.Services.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    ModelMapper mapper;
    @Autowired
    TagRepository tagRepository;
    @Override
    public HResponse getAllTag(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Tag> pageTag;
        pageTag = tagRepository.findAll(pageable);
        List<TagDTO> tagDTOList = pageTag.getContent()
                .stream()
                .map( tag -> mapper.map(tag, TagDTO.class))
                .collect(Collectors.toList());
        return HResponse.buildHResponse(PaginationDTO.buildPaginationDTO(pageTag, tagDTOList));
    }

    @Override
    public HResponse createOrUpdateTag(TagDTO dto) {
        if(dto.getId() != null) {
            if(!tagRepository.existsById(dto.getId())){
                return HResponse.buildHResponse(ErrorMessage.TAG_NOT_EXIST);
            }
        }else{
            dto.setIsActive(1);
        }
        Tag tag = tagRepository.save(mapper.map(dto, Tag.class));

        return HResponse.buildHResponse(tag, dto.getId()!=null?ErrorMessage.UPDATE_SUCCESS:ErrorMessage.CREATE_SUCCESS);
    }
}

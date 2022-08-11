package heroku.app.demo.Services.implService;

import heroku.app.demo.DTOs.MaterialDTO;
import heroku.app.demo.DTOs.TagDTO;
import heroku.app.demo.Entities.Material;
import heroku.app.demo.Entities.Tag;
import heroku.app.demo.Exceptions.ErrorMessage;
import heroku.app.demo.HResponse.HResponse;
import heroku.app.demo.Payload.PaginationDTO;
import heroku.app.demo.Repositories.MaterialRepository;
import heroku.app.demo.Services.MaterialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialRepository materialRepository;
    @Autowired
    ModelMapper mapper;
    @Override
    public HResponse getAllMaterial(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Material> pageMaterial;
        pageMaterial = materialRepository.findAll(pageable);
        List<MaterialDTO> materialDTOList = pageMaterial.getContent()
                .stream()
                .map( tag -> mapper.map(tag, MaterialDTO.class))
                .collect(Collectors.toList());
        return HResponse.buildHResponse(PaginationDTO.buildPaginationDTO(pageMaterial, materialDTOList));
    }

    @Override
    public HResponse createOrUpdateMaterial(MaterialDTO dto) {
        if(dto.getId() != null) {
            if(!materialRepository.existsById(dto.getId())){
                return HResponse.buildHResponse(ErrorMessage.MATERIAL_NOT_EXIST);
            }
        }else{
            dto.setIsActive(1);
        }
        Material material = materialRepository.save(mapper.map(dto, Material.class));

        return HResponse.buildHResponse(material, dto.getId()!=null?ErrorMessage.UPDATE_SUCCESS:ErrorMessage.CREATE_SUCCESS);
    }
}

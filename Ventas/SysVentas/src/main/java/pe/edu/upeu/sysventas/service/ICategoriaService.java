package pe.edu.upeu.sysventas.service;

import pe.edu.upeu.sysventas.dto.ComboBoxOption;
import pe.edu.upeu.sysventas.model.Categoria;
import pe.edu.upeu.sysventas.repository.ICrudGenericoRepository;

import java.util.List;

public interface ICategoriaService extends ICrudGenericoService<Categoria,Long> {
    List<ComboBoxOption> listarCombobox();
}

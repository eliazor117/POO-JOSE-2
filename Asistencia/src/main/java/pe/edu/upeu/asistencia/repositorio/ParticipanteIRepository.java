package pe.edu.upeu.asistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.asistencia.modelo.Participante;
//crud
public interface ParticipanteIRepository extends JpaRepository<Participante, String> {
}

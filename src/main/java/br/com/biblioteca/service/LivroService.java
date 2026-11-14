package br.com.biblioteca.service;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() { return repository.findAll(); }
    public List<Livro> pesquisar(String termo) {
        return repository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(termo, termo);
    }
    public Livro buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Livro não encontrado: " + id));
    }
    public Livro salvar(Livro livro) { return repository.save(livro); }
    public void excluir(Long id) { repository.deleteById(id); }
}

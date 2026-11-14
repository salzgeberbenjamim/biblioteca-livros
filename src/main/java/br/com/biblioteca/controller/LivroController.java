package br.com.biblioteca.controller;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/livros")
public class LivroController {
    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        model.addAttribute("livros",
            (busca == null || busca.isBlank()) ? service.listarTodos() : service.pesquisar(busca.trim()));
        model.addAttribute("busca", busca == null ? "" : busca);
        return "livros/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("tituloPagina", "Cadastrar livro");
        return "livros/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("livro") Livro livro,
                         BindingResult resultado, Model model,
                         RedirectAttributes redirect) {
        if (resultado.hasErrors()) {
            model.addAttribute("tituloPagina", livro.getId() == null ? "Cadastrar livro" : "Editar livro");
            return "livros/formulario";
        }
        service.salvar(livro);
        redirect.addFlashAttribute("mensagem", "Livro salvo com sucesso!");
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("livro", service.buscarPorId(id));
        model.addAttribute("tituloPagina", "Editar livro");
        return "livros/formulario";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirect) {
        service.excluir(id);
        redirect.addFlashAttribute("mensagem", "Livro excluído com sucesso!");
        return "redirect:/livros";
    }
}

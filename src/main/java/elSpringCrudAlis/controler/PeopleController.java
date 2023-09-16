package elSpringCrudAlis.controler;

import elSpringCrudAlis.dao.PersonDao;
import elSpringCrudAlis.models.Person;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/people")
public class PeopleController {

    //Должны внедрить объект в контролер

    private final PersonDao personDao;
    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model){
        // Получим всех людей из ДАО и передадим на отображение
        model.addAttribute("people", personDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        // получим одног(id)о человека и предадим егона отображение
        model.addAttribute("person",personDao.show(id));
        return "people/show";
    }


    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }
    @PostMapping
    public String create(@ModelAttribute("person") @Valid @RequestBody Person person,
                         BindingResult bindingResult){
        //@Valid нужна чтобы выолнялись условия валидации которые мы роисали в классе Person
        // отчет появляеться BindingResult bindingResult
        // и он должен идти сразу после объекта на котором мы вызываем валидацию
        if (bindingResult.hasErrors()){
            return "people/new";
            // возвращаем форму зароса @GetMapping("/new") public String newPerson(Model model)
        }
        personDao.save(person);
        return "people/successful"; //"redirect:/people";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person",personDao.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()){
            return "people/edit";
        }
        personDao.update(id,person);
        return "redirect:/people";
    }


    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id){
        personDao.deletePerson(id);
        return "redirect:/people";
    }



}

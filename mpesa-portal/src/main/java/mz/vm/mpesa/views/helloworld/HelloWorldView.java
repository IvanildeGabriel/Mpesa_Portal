package mz.vm.mpesa.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.RegexpValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import mz.vm.mpesa.service.ClientServiceCaller;
import mz.vm.mpesa.service.DocumentServiceCaller;
import mz.vm.mpesa.views.main.MainView;
import mz.vm.portal.ClientDTO;
import mz.vm.portal.DocumentTypeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Route(value = "Hello", layout = MainView.class)
@PageTitle("MPESA PORTAL")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends HorizontalLayout {

    private ClientServiceCaller clientServiceCaller;
    private DocumentServiceCaller documentServiceCaller;
    //    Form Layout
    private FormLayout layoutWithBinder = new FormLayout();
    //    Binder
    private Binder<ClientDTO> binder;
    private ClientDTO clientDTOBeingEdited;
    //    Form Fields
    private TextField firstName;
    private TextField lastName;
    private TextField phone;
    //    private DatePicker birthDate;
    private Label infoLabel;
    private TextField docNumber;
    private ComboBox<DocumentTypeDTO> docType;


    //    Action Layout and Buttons
    private HorizontalLayout actions;
    private Button save;
    private Button reset;

    public HelloWorldView() {
        setId("hello-world-view");
        clientServiceCaller = new ClientServiceCaller();
        documentServiceCaller = new DocumentServiceCaller();
        clientDTOBeingEdited = new ClientDTO();
        this.setResponsiveForm(layoutWithBinder);
        this.createFields();
        this.setupComboBox();
        this.defineForm();
        this.defineActionLayout();
        this.binderFields();
        this.buttonsEvents();
        this.add(layoutWithBinder, actions, infoLabel);
    }

    private void setupComboBox() {
        List<DocumentTypeDTO> list = new ArrayList<>();
        documentServiceCaller.finAll().forEach(documentTypeDTO -> list.add(documentTypeDTO));
        docType.setItems(list);
        docType.setItemLabelGenerator(item -> item.getName());
    }

    private void binderFields() {
        binder = new Binder();
        binder.forField(firstName).asRequired()
                .withValidator(new StringLengthValidator(
                        "Preencha o Nome", 2, 60))
                .bind(ClientDTO::getName, ClientDTO::setName);
        binder.forField(lastName).asRequired()
                .withValidator(new StringLengthValidator(
                        "Preencha o Apelido", 2, 60))
                .bind(ClientDTO::getLastname, ClientDTO::setLastname);
        binder.forField(docNumber).asRequired("Preencha o numero").bind(ClientDTO::getDocNumber, ClientDTO::setDocNumber);
        binder.forField(docType).asRequired("Seleccione o documento").bind(ClientDTO::getDocumentTypeDTO, ClientDTO::setDocumentTypeDTO);
//        binder.forField(birthDate).asRequired("Seleccione a Data").withConverter(convertLocalDateToDate())
//                .bind(ClientDTO::getBirthDate, ClientDTO::setBirthDate);
        binder.forField(phone).asRequired()
                .withValidator(new RegexpValidator("preencha o numero de Telefone", "8(4|5)[0-9]{7}$"))
                .bind(ClientDTO::getCellphone, ClientDTO::setCellphone);
    }

    private void buttonsEvents() {
        save.addClickListener(event -> {
            if (binder.writeBeanIfValid(clientDTOBeingEdited)) {
                ClientDTO saved = clientServiceCaller.save(clientDTOBeingEdited);
                infoLabel.setText("Gravado com Sucesso: "+saved);
//                List<ClientDTO> clientDTOS = clientServiceCaller.finAll();
            } else {
                BinderValidationStatus<ClientDTO> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
                infoLabel.setText("Erros no Formulário: " + errorText);
            }
        });
        reset.addClickListener(event -> {
            // clear fields by setting null
            binder.readBean(null);
            infoLabel.setText("");
        });
    }

    private void defineActionLayout() {
        actions = new HorizontalLayout();
        save = new Button("Guardar");
        save.addThemeVariants(ButtonVariant.LUMO_SMALL,
                ButtonVariant.LUMO_PRIMARY);
        save.getStyle().set("marginRight", "10px");
        reset = new Button("Limpar");
        reset.addThemeVariants(ButtonVariant.LUMO_SMALL);
        actions.add(save, reset);
    }

    private void defineForm() {
        layoutWithBinder.addFormItem(firstName, "Nome");
        layoutWithBinder.addFormItem(lastName, "Apelido");
//        layoutWithBinder.addFormItem(birthDate, "Data de Nascimento");
        layoutWithBinder.addFormItem(docType, "Tipo de Documento");
        layoutWithBinder.addFormItem(phone, "Numero de Telefone");
        layoutWithBinder.addFormItem(docNumber, "Numero de Documento");
    }

    private void createFields() {
        firstName = new TextField();
        lastName = new TextField();
        phone = new TextField();
//        birthDate = new DatePicker();
        docNumber = new TextField();
        infoLabel = new Label();
        docType = new ComboBox();
//        Define Properties
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
        phone.setValueChangeMode(ValueChangeMode.EAGER);
        firstName.setWidthFull();
        lastName.setWidthFull();
//        birthDate.setWidthFull();
        docType.setWidth("50%");
        docNumber.setWidth("50%");
    }

    private void setResponsiveForm(FormLayout... form) {
        for (FormLayout formLayout : form) {
            formLayout.setResponsiveSteps(
                    new FormLayout.ResponsiveStep("0", 2));
        }
    }

}

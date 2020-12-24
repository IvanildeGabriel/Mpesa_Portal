package mz.vm.mpesa.views.Utils;

import com.vaadin.componentfactory.EnhancedDatePicker;
import com.vaadin.flow.component.*;
import com.vaadin.flow.dom.ClassList;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.shared.Registration;
import elemental.json.JsonObject;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public class FormatedDatePicker extends EnhancedDatePicker {

    public FormatedDatePicker() {
        super();
        this.setupDatePicker(this, false);
    }

    public FormatedDatePicker(LocalDate initialDate) {
        super(initialDate);
        this.setupDatePicker(this, false);
    }

    public FormatedDatePicker(String label) {
        super(label);
        this.setupDatePicker(this, false);
    }

    public FormatedDatePicker(String label, LocalDate initialDate) {
        super(label, initialDate);
        this.setupDatePicker(this, false);
    }

    public FormatedDatePicker(HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<EnhancedDatePicker, LocalDate>> listener) {
        super(listener);
        this.setupDatePicker(this, false);
    }

    public FormatedDatePicker(String label, HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<EnhancedDatePicker, LocalDate>> listener) {
        super(label, listener);
        this.setupDatePicker(this, false);
    }

    public FormatedDatePicker(LocalDate initialDate, HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<EnhancedDatePicker, LocalDate>> listener) {
        super(initialDate, listener);
        this.setupDatePicker(this, false);
    }

    public FormatedDatePicker(String label, LocalDate initialDate, HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<EnhancedDatePicker, LocalDate>> listener) {
        super(label, initialDate, listener);
        this.setupDatePicker(this, false);
    }

    public FormatedDatePicker(LocalDate initialDate, Locale locale) {
        super(initialDate, locale);
        this.setupDatePicker(this, false);
    }

    public FormatedDatePicker(LocalDate initialDate, String pattern) {
        super(initialDate, pattern);
        this.setupDatePicker(this, false);

    }


    public static void setupDatePicker(FormatedDatePicker picker, boolean isRequired) {
        picker.setPattern("dd-MM-yyyy");
        DatePickerI18n datePickerI18n = new DatePickerI18n();
        datePickerI18n.setCancel("Cancelar");
        datePickerI18n.setToday("Hoje");
        datePickerI18n.setClear("Limpar");
        picker.setClearButtonVisible(true);
        datePickerI18n.setMonthNames(Arrays.asList("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"));
        datePickerI18n.setWeekdays(Arrays.asList("Segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado", "domingo"));
        datePickerI18n.setWeekdaysShort(Arrays.asList("Seg", "ter", "quar", "quint", "sext", "sab", "domg"));
        picker.setI18n(datePickerI18n);
        picker.setRequiredIndicatorVisible(isRequired);
    }


    @Override
    public void setMin(LocalDate min) {
        super.setMin(min);
    }

    @Override
    public LocalDate getMin() {
        return super.getMin();
    }

    @Override
    public void setMax(LocalDate max) {
        super.setMax(max);
    }

    @Override
    public LocalDate getMax() {
        return super.getMax();
    }

    @Override
    public void setLocale(Locale locale) {
        super.setLocale(locale);
    }

    @Override
    public Locale getLocale() {
        return super.getLocale();
    }

    @Override
    public void setPattern(String pattern) {
        super.setPattern(pattern);
    }

    @Override
    public String getPattern() {
        return super.getPattern();
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
    }

    @Override
    public DatePickerI18n getI18n() {
        return super.getI18n();
    }

    @Override
    public void setI18n(DatePickerI18n i18n) {
        super.setI18n(i18n);
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        super.setErrorMessage(errorMessage);
    }

    @Override
    public String getErrorMessage() {
        return super.getErrorMessage();
    }

    @Override
    public void setInvalid(boolean invalid) {
        super.setInvalid(invalid);
    }

    @Override
    public boolean isInvalid() {
        return super.isInvalid();
    }

    @Override
    public void setClearButtonVisible(boolean clearButtonVisible) {
        super.setClearButtonVisible(clearButtonVisible);
    }

    @Override
    public boolean isClearButtonVisible() {
        return super.isClearButtonVisible();
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(label);
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }

    @Override
    public void setPlaceholder(String placeholder) {
        super.setPlaceholder(placeholder);
    }

    @Override
    public String getPlaceholder() {
        return super.getPlaceholder();
    }

    @Override
    public void setInitialPosition(LocalDate initialPosition) {
        super.setInitialPosition(initialPosition);
    }

    @Override
    public LocalDate getInitialPosition() {
        return super.getInitialPosition();
    }

    @Override
    public void setRequired(boolean required) {
        super.setRequired(required);
    }

    @Override
    public boolean isRequired() {
        return super.isRequired();
    }

    @Override
    public void setWeekNumbersVisible(boolean weekNumbersVisible) {
        super.setWeekNumbersVisible(weekNumbersVisible);
    }

    @Override
    public boolean isWeekNumbersVisible() {
        return super.isWeekNumbersVisible();
    }

    @Override
    public void setOpened(boolean opened) {
        super.setOpened(opened);
    }

    @Override
    public void open() {
        super.open();
    }

    @Override
    protected void close() {
        super.close();
    }

    @Override
    public boolean isOpened() {
        return super.isOpened();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Registration addOpenedChangeListener(ComponentEventListener<OpenedChangeEvent<EnhancedDatePicker>> listener) {
        return super.addOpenedChangeListener(listener);
    }

    @Override
    public Registration addInvalidChangeListener(ComponentEventListener<InvalidChangeEvent<EnhancedDatePicker>> listener) {
        return super.addInvalidChangeListener(listener);
    }

    @Override
    protected boolean isAutofocusBoolean() {
        return super.isAutofocusBoolean();
    }

    @Override
    protected void setAutofocus(boolean autofocus) {
        super.setAutofocus(autofocus);
    }

    @Override
    protected boolean isDisabledBoolean() {
        return super.isDisabledBoolean();
    }

    @Override
    protected void setDisabled(boolean disabled) {
        super.setDisabled(disabled);
    }

    @Override
    protected boolean isRequiredBoolean() {
        return super.isRequiredBoolean();
    }

    @Override
    protected String getNameString() {
        return super.getNameString();
    }

    @Override
    protected String getInitialPositionString() {
        return super.getInitialPositionString();
    }

    @Override
    protected void setInitialPosition(String initialPosition) {
        super.setInitialPosition(initialPosition);
    }

    @Override
    protected String getLabelString() {
        return super.getLabelString();
    }

    @Override
    protected boolean isOpenedBoolean() {
        return super.isOpenedBoolean();
    }

    @Override
    protected boolean isShowWeekNumbersBoolean() {
        return super.isShowWeekNumbersBoolean();
    }

    @Override
    protected void setShowWeekNumbers(boolean showWeekNumbers) {
        super.setShowWeekNumbers(showWeekNumbers);
    }

    @Override
    protected JsonObject getI18nJsonObject() {
        return super.getI18nJsonObject();
    }

    @Override
    protected void setI18n(JsonObject i18n) {
        super.setI18n(i18n);
    }

    @Override
    protected String getMinAsStringString() {
        return super.getMinAsStringString();
    }

    @Override
    protected void setMinAsString(String minAsString) {
        super.setMinAsString(minAsString);
    }

    @Override
    protected String getMaxAsStringString() {
        return super.getMaxAsStringString();
    }

    @Override
    protected void setMaxAsString(String maxAsString) {
        super.setMaxAsString(maxAsString);
    }

    @Override
    protected boolean isClearButtonVisibleBoolean() {
        return super.isClearButtonVisibleBoolean();
    }

    @Override
    protected String getErrorMessageString() {
        return super.getErrorMessageString();
    }

    @Override
    protected String getPlaceholderString() {
        return super.getPlaceholderString();
    }

    @Override
    protected boolean isReadonlyBoolean() {
        return super.isReadonlyBoolean();
    }

    @Override
    protected void setReadonly(boolean readonly) {
        super.setReadonly(readonly);
    }

    @Override
    protected boolean isInvalidBoolean() {
        return super.isInvalidBoolean();
    }

    @Override
    protected void validate(String value) {
        super.validate(value);
    }

    @Override
    protected void checkValidity(String value) {
        super.checkValidity(value);
    }

    @Override
    protected Registration addChangeListener(ComponentEventListener<ChangeEvent<EnhancedDatePicker>> listener) {
        return super.addChangeListener(listener);
    }

    @Override
    protected void addToPrefix(Component... components) {
        super.addToPrefix(components);
    }

    @Override
    protected void remove(Component... components) {
        super.remove(components);
    }

    @Override
    protected void removeAll() {
        super.removeAll();
    }

    @Override
    protected void setSynchronizedEvent(String synchronizedEvent) {
        super.setSynchronizedEvent(synchronizedEvent);
    }

    @Override
    protected boolean hasValidValue() {
        return super.hasValidValue();
    }

    @Override
    protected void setPresentationValue(LocalDate newPresentationValue) {
        super.setPresentationValue(newPresentationValue);
    }

    @Override
    public Registration addValueChangeListener(HasValue.ValueChangeListener<? super AbstractField.ComponentValueChangeEvent<EnhancedDatePicker, LocalDate>> listener) {
        return super.addValueChangeListener(listener);
    }

    @Override
    public void setValue(LocalDate value) {
        super.setValue(value);
    }

    @Override
    protected void setModelValue(LocalDate newModelValue, boolean fromClient) {
        super.setModelValue(newModelValue, fromClient);
    }

    @Override
    protected boolean valueEquals(LocalDate value1, LocalDate value2) {
        return super.valueEquals(value1, value2);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public LocalDate getValue() {
        return super.getValue();
    }

    @Override
    public LocalDate getEmptyValue() {
        return super.getEmptyValue();
    }

    @Override
    public Registration addBlurListener(ComponentEventListener<BlurNotifier.BlurEvent<EnhancedDatePicker>> listener) {
        return null;
    }

    @Override
    public Element getElement() {
        return super.getElement();
    }

    @Override
    public Optional<Component> getParent() {
        return super.getParent();
    }

    @Override
    public Stream<Component> getChildren() {
        return super.getChildren();
    }

    @Override
    protected ComponentEventBus getEventBus() {
        return super.getEventBus();
    }

    @Override
    protected <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return super.addListener(eventType, listener);
    }

    @Override
    protected boolean hasListener(Class<? extends ComponentEvent> eventType) {
        return super.hasListener(eventType);
    }

    @Override
    protected void fireEvent(ComponentEvent<?> componentEvent) {
        super.fireEvent(componentEvent);
    }

    @Override
    public Optional<UI> getUI() {
        return super.getUI();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public Optional<String> getId() {
        return super.getId();
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        super.onDetach(detachEvent);
    }

    @Override
    protected <T> void set(PropertyDescriptor<T, ?> descriptor, T value) {
        super.set(descriptor, value);
    }

    @Override
    protected <T> T get(PropertyDescriptor<?, T> descriptor) {
        return super.get(descriptor);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }

    @Override
    public boolean isVisible() {
        return super.isVisible();
    }

    @Override
    public void onEnabledStateChanged(boolean enabled) {
        super.onEnabledStateChanged(enabled);
    }

    @Override
    protected boolean isTemplateMapped() {
        return super.isTemplateMapped();
    }

    @Override
    public String getTranslation(String key, Object... params) {
        return super.getTranslation(key, params);
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        return super.getTranslation(key, locale, params);
    }

    @Override
    public Registration addAttachListener(ComponentEventListener<AttachEvent> listener) {
        return null;
    }

    @Override
    public Registration addDetachListener(ComponentEventListener<DetachEvent> listener) {
        return null;
    }

    @Override
    public void setTabIndex(int tabIndex) {

    }

    @Override
    public int getTabIndex() {
        return 0;
    }

    @Override
    public void focus() {

    }

    @Override
    public void blur() {

    }

    @Override
    public ShortcutRegistration addFocusShortcut(Key key, KeyModifier... keyModifiers) {
        return null;
    }

    @Override
    public Registration addFocusListener(ComponentEventListener<FocusNotifier.FocusEvent<EnhancedDatePicker>> listener) {
        return null;
    }

    @Override
    public void setWidth(String width) {

    }

    @Override
    public void setMinWidth(String minWidth) {

    }

    @Override
    public void setMaxWidth(String maxWidth) {

    }

    @Override
    public String getWidth() {
        return null;
    }

    @Override
    public String getMinWidth() {
        return null;
    }

    @Override
    public String getMaxWidth() {
        return null;
    }

    @Override
    public void setHeight(String height) {

    }

    @Override
    public void setMinHeight(String minHeight) {

    }

    @Override
    public void setMaxHeight(String maxHeight) {

    }

    @Override
    public String getHeight() {
        return null;
    }

    @Override
    public String getMinHeight() {
        return null;
    }

    @Override
    public String getMaxHeight() {
        return null;
    }

    @Override
    public void setSizeFull() {

    }

    @Override
    public void setWidthFull() {

    }

    @Override
    public void setHeightFull() {

    }

    @Override
    public void setSizeUndefined() {

    }

    @Override
    public void addClassName(String className) {

    }

    @Override
    public boolean removeClassName(String className) {
        return false;
    }

    @Override
    public void setClassName(String className) {

    }

    @Override
    public String getClassName() {
        return null;
    }

    @Override
    public ClassList getClassNames() {
        return null;
    }

    @Override
    public void setClassName(String className, boolean set) {

    }

    @Override
    public boolean hasClassName(String className) {
        return false;
    }

    @Override
    public Style getStyle() {
        return null;
    }

    @Override
    public void addClassNames(String... classNames) {

    }

    @Override
    public void removeClassNames(String... classNames) {

    }

    @Override
    public void setRequiredIndicatorVisible(boolean requiredIndicatorVisible) {

    }

    @Override
    public boolean isRequiredIndicatorVisible() {
        return false;
    }

    @Override
    public void setReadOnly(boolean readOnly) {

    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public void setEnabled(boolean enabled) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Optional<LocalDate> getOptionalValue() {
        return Optional.empty();
    }

    @Override
    public void clear() {

    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * {@code x}, {@code x.equals(x)} should return
     * {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * {@code x} and {@code y}, {@code x.equals(y)}
     * should return {@code true} if and only if
     * {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * {@code x}, {@code y}, and {@code z}, if
     * {@code x.equals(y)} returns {@code true} and
     * {@code y.equals(z)} returns {@code true}, then
     * {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * {@code x} and {@code y}, multiple invocations of
     * {@code x.equals(y)} consistently return {@code true}
     * or consistently return {@code false}, provided no
     * information used in {@code equals} comparisons on the
     * objects is modified.
     * <li>For any non-null reference value {@code x},
     * {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     * <p>
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Called by the garbage collector on an object when garbage collection
     * determines that there are no more references to the object.
     * A subclass overrides the {@code finalize} method to dispose of
     * system resources or to perform other cleanup.
     * <p>
     * The general contract of {@code finalize} is that it is invoked
     * if and when the Java&trade; virtual
     * machine has determined that there is no longer any
     * means by which this object can be accessed by any thread that has
     * not yet died, except as a result of an action taken by the
     * finalization of some other object or class which is ready to be
     * finalized. The {@code finalize} method may take any action, including
     * making this object available again to other threads; the usual purpose
     * of {@code finalize}, however, is to perform cleanup actions before
     * the object is irrevocably discarded. For example, the finalize method
     * for an object that represents an input/output connection might perform
     * explicit I/O transactions to break the connection before the object is
     * permanently discarded.
     * <p>
     * The {@code finalize} method of class {@code Object} performs no
     * special action; it simply returns normally. Subclasses of
     * {@code Object} may override this definition.
     * <p>
     * The Java programming language does not guarantee which thread will
     * invoke the {@code finalize} method for any given object. It is
     * guaranteed, however, that the thread that invokes finalize will not
     * be holding any user-visible synchronization locks when finalize is
     * invoked. If an uncaught exception is thrown by the finalize method,
     * the exception is ignored and finalization of that object terminates.
     * <p>
     * After the {@code finalize} method has been invoked for an object, no
     * further action is taken until the Java virtual machine has again
     * determined that there is no longer any means by which this object can
     * be accessed by any thread that has not yet died, including possible
     * actions by other objects or classes which are ready to be finalized,
     * at which point the object may be discarded.
     * <p>
     * The {@code finalize} method is never invoked more than once by a Java
     * virtual machine for any given object.
     * <p>
     * Any exception thrown by the {@code finalize} method causes
     * the finalization of this object to be halted, but is otherwise
     * ignored.
     *
     * @throws Throwable the {@code Exception} raised by this method
     * @jls 12.6 Finalization of Class Instances
     * @see WeakReference
     * @see PhantomReference
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

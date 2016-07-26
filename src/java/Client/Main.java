package Client;

import Entity.BrandEmerson;
import Entity.News;
import Entity.NewsCategory;
import Entity.Page;
import Entity.Product;
import Entity.Project;
import Entity.ServedEmerson;
import Entity.Services;
import Entity.ServicesCategory;
import SessionBean.BrandEmersonFacade;
import SessionBean.NewsCategoryFacade;
import SessionBean.NewsFacade;
import SessionBean.PageFacade;
import SessionBean.ProductFacade;
import SessionBean.ProjectFacade;
import SessionBean.ServedEmersonFacade;
import SessionBean.ServicesCategoryFacade;
import SessionBean.ServicesFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "main")
@SessionScoped
public class Main implements Serializable {

    @ManagedProperty(value = "#{param.lang}")
    private String language;
    @ManagedProperty(value = "#{param.servicesid}")
    private Integer servicesId;
    private String title;
    private List<String> relatedBrand;

    public List<String> getRelatedBrand() {
        relatedBrand = new ArrayList<>();
        relatedBrand.add("EIM");
        relatedBrand.add("Dantorque");
        relatedBrand.add("Bettis");
        relatedBrand.add("El-O-Matic");
        relatedBrand.add("FieldQ");
        relatedBrand.add("and Instruments");
        relatedBrand.add("Fisher Regulators");
        relatedBrand.add("Francel");
        relatedBrand.add("Hytork");
        return relatedBrand;
    }

    public Integer getServicesId() {
        return servicesId;
    }

    public void setServicesId(Integer servicesId) {
        this.servicesId = servicesId;
    }

    @EJB
    private ServicesCategoryFacade serviceCategoryFacade;
    @EJB
    private ServedEmersonFacade servedEmersonFacade;
    @EJB
    private BrandEmersonFacade brandEmersonFacade;
    @EJB
    private ServicesFacade servicesFacade;
    @EJB
    private ProjectFacade projectFacade;

    private Services services;
    private ServicesCategory CoreOffering;
    private List<ServedEmerson> allServed;
    private List<BrandEmerson> allBrand;

    public Services getServices() {
        System.out.println("Client.Main.getServices() : Services Id : " + servicesId);
        if (servicesId != null) {
            return servicesFacade.find(servicesId);
        }
        return this.services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public ServicesCategory getCoreOffering() {
        return serviceCategoryFacade.find(2);
    }

    public void setCoreOffering(ServicesCategory CoreOffering) {
        this.CoreOffering = CoreOffering;
    }

    public String getTitle() {
        if (language == "EN") {
            title = "Piramoon";
        } else {
            title = "پیرامون";
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        System.out.println("Client.Main.getTitle() Language is : " + language);
        if (language == null) {
            return "EN";
        }
        if (language == "EN") {
            return "EN";
        }
        return "FA";
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<ServedEmerson> getAllServed() {
        return servedEmersonFacade.findAll();
    }

    public List<BrandEmerson> getAllBrand() {
        return brandEmersonFacade.findAll();
    }
    // Project Show Code
    @ManagedProperty(value = "#{param.project_id}")
    private Integer project_id;
    private Project project;

    public Project getProject() {
        if (project_id != null) {
            this.project = projectFacade.find(project_id);
        }
        return project;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }
    /////////////////////

    //Show Brads And Product
    private List<BrandEmerson> brands;
    private Product product;
    @ManagedProperty(value = "#{param.product_id}")
    private Integer product_id;
    @EJB
    private ProductFacade productFacade;

    public Product getProduct() {
        if (this.product_id != null) {
            this.product = productFacade.find(this.product_id);
        }
        return product;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public List<BrandEmerson> getBrands() {
        return brandEmersonFacade.findAll();
    }
    /////////////////////

    // News Code
    private List<NewsCategory> newsCategory;
    @EJB
    private NewsCategoryFacade newsCategoryFacade;
    @EJB
    private NewsFacade newsFacade;
    @ManagedProperty(value = "#{param.news_id}")
    private Integer news_id;
    @ManagedProperty(value = "#{param.news_category_id}")
    private Integer newsCategoryId;

    private News news;
    private NewsCategory newsCategorySelect;

    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public NewsCategory getNewsCategorySelect() {
        if (newsCategoryId != null) {
            this.newsCategory = newsCategoryFacade.findAll();
            for (NewsCategory s : newsCategory) {
                if (s.getId() == newsCategoryId) {
                    this.newsCategorySelect = s;
                    break;
                }
            }
        }
        return newsCategorySelect;
    }

    public Integer getNewsCategoryId() {
        return newsCategoryId;
    }

    public List<NewsCategory> getNewsCategory() {
        return newsCategoryFacade.findAll();
    }

    public Integer getNews_id() {
        return news_id;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    public News getNews() {
        if (this.news_id != null) {
            this.news = newsFacade.find(this.news_id);
        }
        return news;
    }
    ///////////////////
    
    //page section
    private Page page;
    @EJB
    private PageFacade pageFacade;
    @ManagedProperty(value = "#{param.pageId}")
    private Integer pageId;

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Page getPage() {
        if(this.pageId != null){
            this.page = pageFacade.find(pageId);
        }
        return page;
    }

    public Integer getPageId() {
        return pageId;
    }
    

}

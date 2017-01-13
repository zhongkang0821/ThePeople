package com.people.bean;

import java.util.List;

public class DateilsBean {

    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     <div class="headline-background">
     <a class="headline-background-link" href="http://www.qdaily.com/articles/36599.html">
     <div class="heading">相关新闻</div>
     <div class="heading-content">特斯拉开始推送第二代自动驾驶系统</div>
     <i class="icon-arrow-right"></i>
     </a>
     </div>

     </div>

     <div class="content-inner">




     <div class="question">
     <h2 class="question-title"></h2>

     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic3.zhimg.com/v2-52dc7e21f34e9954118480ed00e705fa_is.jpg">
     <span class="author">王飞，</span><span class="bio">自动驾驶控制器研发，技术控..</span>
     </div>

     <div class="content">
     <p>特斯拉的自动驾驶一直被业界所瞩目，很多人也都相信特斯拉已经实现或将最先实现自动驾驶。</p>
     <p>然而，事实真的如此吗？</p>
     <p>从事自动驾驶控制器研发也有一段时间了，谈谈看法。</p>
     <p><strong>什么是自动驾驶？</strong></p>
     <p>自动驾驶目前还没有强制标准的认定，欧标没有，美标没有，国标更没有！</p>
     <p>这就给&ldquo;自动驾驶&rdquo;的解释留下了非常大的空间！</p>
     <p>能够自动加速制动算不算自动驾驶，能够自动转向算不算自动驾驶？到什么程度才算自动驾驶？</p>
     <p>虽然没有强制标准，但美国高速公路交通安全管理局(NHTSA)和美国汽车工程师学会(SAE)对此有较为明确的说明。</p>
     <p>基本分为 4-5 级，网上有非常多的资料，仅仅简述：</p>
     <p>0 级：没有辅助系统</p>
     <p>1 级：基本的辅助系统，如自适应巡航控制，车道保持。</p>
     <p><strong>2 级：综合各种一级系统，称之为半自动化系统。属于辅助驾驶范畴。</strong></p>
     <p><strong>3 级：有条件的自动驾驶系统，真正的自动驾驶系统，但仅工作于特定条件，仍需驾驶员接管。</strong></p>
     <p>4 级(5 级)：高度(完全)自动驾驶，甚至无人驾驶。</p>
     <p>2 级和 3 级最大的区别来自于<strong>是否需要驾驶员负责</strong>，2 级需要驾驶员负责，3 级不需要驾驶员负责。</p>
     <p><strong>如果车厂要求驾驶员手不离方向盘，时刻关注路面情况，那么无疑是 2 级系统。</strong></p>
     <p>注意！是驾驶员<strong>负责</strong>！不是驾驶员<strong>接管！</strong>3 级仍然需要驾驶员接管，驾驶员接管是 3 级和 4 级 5 级的区别！</p>
     <p><strong>目前上市的所有车型，包括特斯拉、沃尔沃、奔驰、奥迪等品牌全部车型最高级的系统仅仅到二级，三级系统在世界上任何一个地方都还没有上市！</strong></p>
     <p>有信息表明奥迪会成为第一个量产 3 级自动驾驶的品牌，因其与激光雷达供应商签订了独家供货协议，激光雷达又是自动驾驶必要传感器之一。但按其发布时间表量产或者上市至少是一两年之后的事。</p>
     <p><strong>那么到底 3 级系统困难在哪里？</strong></p>
     <p>可以很明确的说，难度在于<strong>需要对发生的事故负责！</strong></p>
     <p>对于 2 级系统，可以实现各种花哨的功能，但都需要驾驶员在环监控车辆运行，3 级系统驾驶员不在环，所有控制决策都由车辆完成。</p>
     <p>因此，从设计架构到控制逻辑和 2 级系统都有天壤之别！</p>
     <p><strong>所以经常听人问，为什么 3 级系统这也不能干那也不能干，功能还不如 2 级？</strong></p>
     <p>当你真正理解 3 级和 2 级的区别，这个问题就不难回答了。</p>
     <p><strong>功能不是 3 级系统关注的重点，可靠性安全性才是。</strong></p>
     <p><strong>3 级有多远？4 级 5 级有多远？</strong></p>
     <p>3 级系统在未来 5-8 年会陆续量产。</p>
     <p>至于 4 级 5 级，不需要驾驶员接管的，恐怕还需要至少二十年才能量产。</p>
     <p>对于特斯拉宣称的所谓的&ldquo;高度自动驾驶"，我无论如何解释都会有粉丝对我的论述不屑，并坚信特斯拉能够做到。</p>
     <p><strong>然而，我们只要关注，安装此系统的特斯拉汽车上市之后，是否会允许驾驶员开车时松开手并做其他事情，如果没有那么就是 2 级系统！连 3 级都够不上，更别说 4 级 5 级！</strong></p>
     <p><strong>特斯拉系统的技术分析：</strong></p>
     <p>特斯拉在和 Mobileye 分手之后选择了 Nvidia 并全向装有摄像头。</p>
     <p>然而以目前技术摄像头性能<strong>局限性非常大，并且不够安全。</strong></p>
     <p>有人会说人工智能深度学习种种，确实识别是这些技术最好的用武之地，然而这些技术本身并不成熟，对性能提升目前很有限。</p>
     <p><strong>自动驾驶是对安全性要求极高的系统，不允许任何形式的失效（失效后有冗余系统保证安全）。</strong></p>
     <p>而摄像头：</p>
     <p>1、对特殊情况适应不足。比如我们测试中发现面对强光或强地面反光时识别率会下降。</p>
     <p>2、在夜晚需要辅助照明。前向摄像头有大灯，但其他方向摄像头需要额外照明才能在黑暗中工作。照明不足时，识别率和识别距离都大幅降低。</p>
     <p>3、恶劣天气，受雨雪雾影响巨大。雷达激光相对受影响小于摄像头。</p>
     <p>4、识别本身有局限，比如目标受遮挡，比如目标反差过低，比如目标突然出现。</p>
     <p><strong>对于肉眼都看不清的物体不要指望摄像头能识别。</strong></p>
     <p><strong>想想特斯拉的第一起事故，主要问题在于摄像头没有识别并确认横向运动的货车。<br /></strong></p>
     <p><strong>因此仅依靠摄像头确实无法达到 3 级自动驾驶所需的安全性和可靠性。</strong></p>
     <p><strong>特斯拉的系统更像是低成本高性能的 2 级系统。</strong></p>
     <p><strong>不是说特斯拉系统不好，特斯拉的 Autopilot 是我所测试过性能最好价格最合理的 2 级系统。</strong></p>
     <p><strong>特斯拉也是目前唯一有能力摆脱传统供应商束缚的主机厂。</strong></p>
     <p><strong>但是，实事求是，目前真不觉得，特斯拉这套系统能到 3 级，5 级根本不可能！</strong></p>
     </div>
     </div>


     <div class="view-more"><a href="http://www.zhihu.com/question/51788894">查看知乎讨论<span class="js-question-holder"></span></a></div>

     </div>


     </div>
     </div>
     * image_source : Yestone.com 版权图片库
     * title : 特斯拉说自己实现了「完全自动驾驶」，我有点不相信
     * image : http://pic2.zhimg.com/e985b0f73a260dfc05217e739f959c85.jpg
     * share_url : http://daily.zhihu.com/story/9146068
     * js : []
     * ga_prefix : 011314
     * images : ["http://pic2.zhimg.com/1c2a09df622a5d9bf857c2ec759c94a1.jpg"]
     * type : 0
     * id : 9146068
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<?> js;
    private List<String> images;
    private List<String> css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<?> getJs() {
        return js;
    }

    public void setJs(List<?> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}

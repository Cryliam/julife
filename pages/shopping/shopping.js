// pages/shopping/shopping.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tag: "6",
    selected:0,
    cmdlist: [],
    display1:'flex',
    display2:'none',
    color1:'red',
    color2:'black',
    tags: [
      {"tag":"6","name":"饮料酒水"},
      {"tag":"1","name":"面包饼干"},
      {"tag":"2","name":"膨化食品"},
      {"tag":"3","name":"生活用品"},
      {"tag":"4","name":"洗漱用品"},
      {"tag":"5","name":"文具笔记"},
    ],
    cart:[],
    imgUrl:'http://localhost:7070/julife/images/',
    url:'http://localhost:7070/julife/'

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var newthis = this;

    wx.request({
      url: newthis.data.url+'GetCmd',
      data: {
        tag: newthis.data.tag
      },
      success: function (res) {
        newthis.setData({
          cmdlist: res.data
        })
      }


    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },


  showcmd: function (event) {
    var newtag = event.currentTarget.dataset.tag;
    var newindex=event.currentTarget.dataset.index;
    var newthis = this;


    wx.request({
      url: newthis.data.url+'GetCmd',
      data: {
        tag: newtag
      },
      success: function (res) {
        newthis.setData({
          cmdlist: res.data,
          selected:newindex,
          tag:newtag
        })
      }
    })
  },

  switch:function(event){
    var con = event.currentTarget.dataset.con;
    if(con=='2'){
      this.setData({
        display1:'none',
        display2:'flex',
        color1:'black',
        color2:'red'
      })
    }

    else if(con=='1'){
      this.setData({
        display1: 'flex',
        display2: 'none',
        color1:'red',
        color2:'black'
      })
    }
  },

  addCmd:function(event){
    var cmdId=event.currentTarget.dataset.cmdid;
    var cmdName=event.currentTarget.dataset.cmdname;
    var num=1;
    var isIn=false;
    var newthis=this;
    var newCart=this.data.cart;
    var newItem={"cmdName":cmdName,"cmdId":cmdId,"num":num};
    for(var i=0;i<newCart.length;i++){
      if(newCart[i].cmdId==cmdId){
        newCart[i].num++;
        isIn=true;
      }
    }
    if(isIn==false ||newCart.length==0){
     newCart.push(newItem);
    }
    newthis.setData({
      cart:newCart
    })
  },

  submit:function(){
    var newthis=this;
    var app=getApp();
    var user_id=wx.getStorageSync('userid');
    var cart=newthis.data.cart;
    var newCart=new Array;
    var text="";
    for(var i=0;i<cart.length;i++){
      var cmdName=cart[i].cmdName;
      var num=cart[i].num+"";
      text =text+cmdName+"X"+num+"\n"
    }
    wx.request({
      url: newthis.data.url+'AddRequest',
      method:'post',
      header: {
        'content-type': 'application/x-www-form-urlencoded' 
      },
      data:{
        text:text,
        userId:user_id,
        userName: app.globalData.userInfo.nickName,
        type:1
      },
    })
  }
})

// pages/taxi/taxi.js
var app = getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
    openid:wx.getStorageSync('openid'),

    display1:'flex',
    display2:'none',
    displayExtra:[],
    color1:'red',
    color2:'black',
    url:'http://localhost:7070/julife/',
    list:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var newThis=this;
    var newExtra=this.data.displayExtra;
    var flag=wx.getStorageSync('flag');
    if(flag!=null &&flag==true){
      wx.navigateTo({
        url: '/pages/mine/my_taxi/my_taxi',
      })
    }
    else if(flag==null || flag==false){
      wx.request({
        url: newThis.data.url+'GetTaxiCms',
        data:{
          openid:newThis.data.openid
        },
        method: 'post',
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        success:function(res){
          var flag=res.data.flag;
          if(flag==true){

            wx.setStorageSync('taxiCms', res.data);
            wx.setStorageSync('flag', true)
            wx.navigateTo({
              url: '/pages/mine/my_taxi/my_taxi',
            })
          }
          else if(flag==null){
            newThis.setData({
              list:res.data
            })
            for (var i = 0; i < newThis.data.list.length; i++) {
              newExtra.push('none')
            }
            newThis.setData({
              displayExtra:newExtra
            })
          }
        }
      })
    }
 
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
  switch: function (event) {
    var con = event.currentTarget.dataset.con;
    if (con == '2') {
      this.setData({
        display1: 'none',
        display2: 'flex',
        color1: 'black',
        color2: 'red'
      })
    }

    else if (con == '1') {
      this.setData({
        display1: 'flex',
        display2: 'none',
        color1: 'red',
        color2: 'black'
      })
    }
  },

  showExtra:function(event){
    var index = event.currentTarget.dataset.index;
    var newExtra=this.data.displayExtra;
    for(var i=0;i<newExtra.length;i++){
      newExtra[i]='none';
    }
    newExtra[index]='flex';
    this.setData({
      displayExtra:newExtra
    })
  },

  submit:function(e){
    var newThis=this;
    var myAim=e.detail.value.aim;
    var myTemp=e.detail.value.temp;
    var myNumber=e.detail.value.number;
    var myTel=e.detail.value.tel;
    var myName = app.globalData.userInfo.nickName;
    var myAvatar = app.globalData.userInfo.avatarUrl;
    var myGender = app.globalData.userInfo.gender;
    var myOpenid = wx.getStorageSync('openid');

    wx.request({
      url: newThis.data.url+'AddTaxiRequest',
      data:{
        openid:myOpenid,
        aim:myAim,
        temp:myTemp,
        tel:myTel,
        name:myName,
        avatar:myAvatar,
        gender:myGender,
        number:myNumber
      },
      method: 'post',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
    })
  }


})
